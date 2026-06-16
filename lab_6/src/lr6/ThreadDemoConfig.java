package lr6;

public final class ThreadDemoConfig {
    private ThreadDemoConfig() {
    }

    public static boolean isDemoMode() {
        return Boolean.parseBoolean(System.getProperty("lab6.demo", "false"));
    }

    public static int getNameAndTimeDurationSeconds() {
        return isDemoMode() ? 3 : 10;
    }

    public static long getNumberPrintDelayMs() {
        return isDemoMode() ? 200L : 1000L;
    }
}
