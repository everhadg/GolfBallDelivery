package edu.rosehulman.golfballdelivery;

import android.app.Activity;
import android.widget.Toast;

import edu.rosehulman.me435.RobotActivity;

public class Scripts {
    private Activity mActivity

    public Scripts(Activity activity){
        mActivity = activity;
    }

    public void testStraightScript(){
        mActivity.sendWheelSpeed(mActivity.mLeftStraightPwmValue, mActivity.mRightStraightPwmValue);
        Toast.makeText(mActivity, "Begin driving",Toast.LENGTH_SHORT).show();
    }

    public void nearBallScript(){
        double distanceToNearBall = NavUtils.getDistance(15,0,90,50);
        long driveTimeMs = (long) (distanceToNearBall/ RobotActivity.DEFAULT_SPEED_FT_PER_SEC*1000);

        // FOR testing this has been made shorter
        driveTimeMs = 3000;

        mActivity.sendWheelSpeed(mActivity.mLeftStraightPwmValue, mActivity.mRightStraightPwmValue);

    }

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
