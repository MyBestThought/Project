package com.yht.page;

import org.springframework.stereotype.Component;

/**
 * 分页显示的类信息
 */

@Component
public class Page {
    private int page;
    private int rows;
    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return offset = (page-1)*rows;
    }

    public void setOffset() {
        this.offset = (page-1)*rows;
    }
}
