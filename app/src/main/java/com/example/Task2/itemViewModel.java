package com.example.Task2;

public class itemViewModel {

    private String bookName;
    private String authorName;
    private int imResource;
    private String pagesNumber;

    public itemViewModel(String bookName, String authorName, int imResource,String pagesNumber) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.imResource = imResource;
        this.pagesNumber = pagesNumber;
    }

    public String getPagesNumber() {
        return pagesNumber;
    }

    public int getImResource() {
        return imResource;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookName() {

        return bookName;
    }

}
