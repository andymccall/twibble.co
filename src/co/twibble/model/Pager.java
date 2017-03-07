package co.twibble.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andymccall on 06/03/2017.
 */
public class Pager<T> {

    private List list;
    private int size;
    private int pageSize;
    private int numberOfPages;

    public Pager(List<T> list) {
        this.list = new ArrayList(list);
    }

    public Pager(List<T> list, int pageSize) {
        this.list = new ArrayList(list);
        setPageSize(pageSize);
    }

    public int getSize() {
        return this.list.size();
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int size) {
        if (size>1) {
            this.pageSize = size;
            Double lastPage = Math.ceil(this.list.size() / this.getPageSize());
            this.numberOfPages = lastPage.intValue();
        } else {
            throw new IllegalArgumentException("Size has to be greater that 0");
        }
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public Page<T> getPage(int pageNumber) {

        Page<T> page = new Page<>();
        int postNumber;

        if(pageNumber > 1) {
            postNumber = pageSize*pageNumber;
        } else {
            postNumber = 0;
        }

        for (int i=1; i<=this.getPageSize(); i++) {
            if (postNumber+i < list.size()) {
                page.contents.add((T)list.get(postNumber+i));
            }
        }

        int lastPage=0;
        int firstPage=0;
        int loopPage=0;

        while (loopPage < pageNumber) {
            loopPage++;
            if (loopPage > lastPage) {
                lastPage = (lastPage + pageSize);
                firstPage = lastPage - pageSize + 1;
                if (lastPage > numberOfPages) {
                    lastPage = numberOfPages;
                    firstPage = lastPage - pageSize + 1;
                }
            }
        }

        page.setFirstPage(firstPage);
        page.setLastPage(lastPage);

        return page;
    }

}