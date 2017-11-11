package com.lib.am.api.exceptions;

/**
 * Created by sasmi_000 on 30-Oct-15.
 */
public class AMViewNotFoundException extends IllegalStateException {
    public AMViewNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public AMViewNotFoundException() {
        this("View must not be null!");
    }
}
