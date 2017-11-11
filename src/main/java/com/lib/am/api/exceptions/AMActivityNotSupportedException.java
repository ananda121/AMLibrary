package com.lib.am.api.exceptions;

/**
 * Created by sasmi_000 on 30-Oct-15.
 */
public class AMActivityNotSupportedException extends IllegalStateException {
    public AMActivityNotSupportedException(String detailMessage) {
        super(detailMessage);
    }

    public AMActivityNotSupportedException() {
        this("Activity should be derived from AMBaseActvity!");
    }
}
