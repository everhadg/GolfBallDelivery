package edu.rosehulman.golfballdelivery;

public class Scripts {

    public void farBallScript() {
        mActivity.sendWheelSpeed( 0, 0);
        removeBallAtLocation(mActivity.mFarBallLocation);

        mCommandHandler.postDelayed(() {
            mActivity.sendWheelSpeed(0,0);
            if(mActivity.mWhiteBallLocation !=0) {
                removeBallAtLocation(mActivity.mWhiteBallLocation);
            }
            if (mActivity.mState == GolfBallDeliveryActivity.State.FAR_BALL_SCRIPT) {
                mActivity.setState(GolfBallDeliveryActivity.State.DRIVE_TOWARDS_HOME);
            }
        }, ARM_REMOVAL_TIME);
    }

    private void removeBallAtLocation(final int location) {
        mActivity.sendCommand("ATTACH 111111");
    }
}
