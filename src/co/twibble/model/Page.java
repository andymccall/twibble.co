package co.twibble.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andymccall on 06/03/2017.
 */
public class Page<T> {

    List<T> contents;
    private int firstPage;
    private int lastPage;

    public Page() {
        contents = new ArrayList<>();
    }

    public int getFirstPage() {
        return this.firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return this.lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getContents() {
        return this.contents;
    }

}
