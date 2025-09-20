class OTPSystem {
    private int[] otpArray;
    private final int OTP_COUNT = 10;
    
    public OTPSystem() {
        this.otpArray = new int[OTP_COUNT];
        generateMultipleOTPs();
    }
    
    public int generateSingleOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    
    private void generateMultipleOTPs() {
        for (int i = 0; i < OTP_COUNT; i++) {
            otpArray[i] = generateSingleOTP();
        }
    }
    
    public boolean areOTPsUnique() {
        for (int i = 0; i < otpArray.length; i++) {
            for (int j = i + 1; j < otpArray.length; j++) {
                if (otpArray[i] == otpArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void displayResults() {
        System.out.println("Generated OTPs:");
        for (int i = 0; i < otpArray.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otpArray[i]);
        }
        System.out.println("Are all OTPs unique? " + areOTPsUnique());
    }
}

public class OTPGenerator {
    public static void main(String[] args) {
        OTPSystem otpSystem = new OTPSystem();
        otpSystem.displayResults();
    }
}
