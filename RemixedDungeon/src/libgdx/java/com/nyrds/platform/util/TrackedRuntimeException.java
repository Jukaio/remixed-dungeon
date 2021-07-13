package com.nyrds.platform.util;

public class TrackedRuntimeException extends RuntimeException {

    public TrackedRuntimeException(String message) {
        throw new RuntimeException("Stub!");
    }

    public TrackedRuntimeException(String format, Exception e) {
    }

    public TrackedRuntimeException(Exception e) {
    }
}
