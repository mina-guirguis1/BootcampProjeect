package com.perficient.bcproj.user.exceptions;


public abstract class EntityStateException extends  IllegalStateException {
       protected EntityStateException(String msg) {
            super(msg);
        }
}
