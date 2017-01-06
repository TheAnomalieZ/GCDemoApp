package com.taz.domain;
/**
 * Created by  Maninesan on 12/06/16.
 */
public class LinkedObject {
    private Long id;
    private LinkedObject previousInstance;
    private static long[] longs = new long[100000];

    public LinkedObject(LinkedObject previousInstance) {
        this.id = 1L;
        this.previousInstance = previousInstance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LinkedObject getPreviousInstance() {
        return previousInstance;
    }

    public void setPreviousInstance(LinkedObject previousInstance) {
        this.previousInstance = previousInstance;
    }

    @Override
    public String toString() {
        return "LinkedObject{" +
                "id=" + id +
                ", previousInstance=" + previousInstance +
                '}';
    }
}
