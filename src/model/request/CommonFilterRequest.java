package model.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CommonFilterRequest {
    private static final int DEFAULT_PAGE_SIZE = 6;
    private static final int DEFAULT_PAGE_INDEX = 1;
    private int pageIndex;
    private int pageSize;
    private String sortBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public int getPageIndex() {
        return pageIndex == 0 ? DEFAULT_PAGE_INDEX : pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize == 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy == null ? "createdDate:DESC" : sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CommonFilterRequest{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortBy='" + sortBy + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
