package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInController {
    private CheckInModel theModel;
    private GUI theView;

    public CheckInController(CheckInModel theModel, GUI theView) {
        this.theModel = theModel;
        this.theView = theView;

        this.theView.addLoadTabButtonListener(new loadTabButtonListener());
        this.theView.addCheckInTabButtonListener(new checkInTabButtonListener());
        this.theView.addCloseApplicationTabButtonListener(new closeApplicationTabButtonListener());
        this.theView.addReportTabButtonListener(new reportTabButtonListener());
        this.theView.addFlightDetailsButtonListener(new flightDetailsButtonListener()) ;
        this.theView.addPassengerDetailsButtonListener(new passengerDetailsButtonListener());
        this.theView.addCheckPassengerInButtonListener(new checkPassengerInButtonListener());
        this.theView.addViewListOfCheckedInButtonListener(new viewListOfCheckedInButtonListener());
        this.theView.addUpdateBagInfoButtonListener(new updateBagInfoButtonListener());
    }

    private class loadTabButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            theView.setViewOnLoadButton();
        }
    }

    private class checkInTabButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            theView.setViewOnCheckInPassengerButton();


        }
    }

    private class closeApplicationTabButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            theView.setOnCloseButton();
        }
    }

    private class reportTabButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            theView.setOnReportButton();
            String inform = theModel.generateReport();
            theView.displayMessage(inform);
        }
    }

    private class flightDetailsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String message = theModel.generateFlightInfo();
            theView.setDisplayDetails(message);
        }
    }

    private class passengerDetailsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {

            String message = theModel.generatePassengerInfo();
            theView.setDisplayDetails(message);
        }
    }

    private class checkPassengerInButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String bookingRefCode = theView.getBookingRefCode();
            String lastName = theView.getPassengerLastName();

            theModel.setCurrentPassengerWithBooking(bookingRefCode,lastName);

            // first we have to check if the passenger exists
            if (bookingRefCode == "" || lastName == "")
            {
                theView.displayMessage("Passenger last name or booking reference is empty. \n Please enter the correct details");
            }
            if(theModel.getCurrentPassenger() != null)
            {
                theModel.checkInPassenger(theModel.getCurrentPassenger().getBookingRefCode(),theModel.getCurrentPassenger().getLastName());
                theView.displayMessage("Successfuly Checked In");

            }
            else
            {
                theView.displayMessage("Sorry no passenger exists with this booking reference number and last name \n Please enter the correct details");
            }
        }
    }

    private class viewListOfCheckedInButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String inform = theModel.generateListOfCheckedInPassenger();
            theView.setViewListofCheckedIn(inform);
        }
    }

    private class updateBagInfoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if(theModel.getCurrentPassenger().getBookingRefCode().equals(theView.getBookingRefCode()) &&
                    theModel.getCurrentPassenger().getLastName().equals(theView.getPassengerLastName()))
                {
                    int bagVolume = theView.getBagDimension1()*theView.getBagDimension2()*theView.getBagDimension3();
                    theModel.checkInBag(bagVolume, theView.getBagWeight());
                }
                theView.displayMessage("Bag added successfully");
                if (theModel.getCurrentPassenger().isThereExcessBag())
                {
                    theModel.getCurrentPassenger().excessBagCalculation();
                   theView.setExcessFees(theModel.getCurrentPassenger().getExcessBagCost());
                }
            }
            catch(Exception exc)
            {
                theView.displayMessage(exc.getMessage());
            }
        }
    }
}
