package com.tasktribe.exceptions;

public class JobNotFoundException extends Exception{
    public JobNotFoundException() {
        super("Invalid Job Id");
    }
}
