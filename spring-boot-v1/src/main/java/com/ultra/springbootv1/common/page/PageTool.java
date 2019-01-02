package com.ultra.springbootv1.common.page;

import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @desc: 分页工具类
 * @Author: ZhaoJP
 * @Date: 2018/12/29
 */
public class PageTool<T> implements Serializable {

    /**
     * 当前页
     */
    private Integer page;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 前一页
     */
    private Integer prevPage;

    /**
     * 后一页
     */
    private Integer nextPage;

    /**
     * 页数开始
     */
    private int pageBegin;

    /**
     * 页数结束
     */
    private int pageEnd;

    /**当前分页内容*/
    private List<T> pageData;

    /**
     * @param totalCount 总条数总条数
     */
    public PageTool(Integer totalCount) {
        this(null, totalCount);
    }

    /**
     * @param pageSize   每页显示条数 默认5条
     * @param totalCount 总条数
     */
    public PageTool(Integer pageSize, Integer totalCount) {
        this.page = 1;//默认值
        this.pageSize = (pageSize == null || pageSize <= 0) ? 5 : pageSize;
        this.totalCount = (totalCount > 0) ? totalCount : 0;
        this.totalPages = (this.pageSize > 0 && this.totalCount > 0)
                ? ((this.totalCount - 1) / this.pageSize + 1)
                : 0;
    }

    /**
     * 此处当计算结果小于0时,返回0,防止负值出现.导致hibernate查询(结果集转发错误)错误
     *
     * @return 分页查询的起始位置
     */
    public int getFirstResult() {

        return (this.page - 1) > 0 ? (this.page - 1) * this.pageSize : 0;
    }

    /**
     * @return 从起始位置开始查询多少条
     */
    public int getMaxResult() {
        //第一页 总数就不足的情况
        if (this.totalCount <= this.pageSize) {
            return this.pageSize;
        }

        int maxResult = this.totalCount - ((this.page - 1) * this.pageSize);
        if (maxResult > 0 && maxResult <= this.pageSize) {
            return maxResult;
        } else if (maxResult > this.pageSize) { // 还有很多分页的情况
            return this.pageSize;
        }
        return 0;
    }

    /**
     * @return 返回前一页
     */
    public int getPrevPage() {

        return (this.page <= 1) ? 1 : this.page - 1;
    }

    /**
     * @return 返回后一页
     */
    public int getNextPage() {

        return ((this.page + 1) >= this.totalPages) ? totalPages : this.page + 1;
    }

    public int getPageBegin() {
        if (this.getTotalPages() > 10) {
            if ((this.getPage() / 10) > 0) {
                if (this.getPage() % 10 == 9) {
                    pageBegin = ((this.getPage()) / 10) * 10 + 9;
                } else {
                    pageBegin = (this.getPage() / 10) * 10;
                }
            } else {
                pageBegin = (this.getPage() / 10) * 10 + 1;
            }
            if (this.getPageEnd() == this.getTotalPages()) {
                pageBegin = this.getTotalPages() - 9;
            }
        } else {
            pageBegin = 1;
        }
        return pageBegin;
    }

    public int getPageEnd() {
        if (this.getTotalPages() > 10) {
            if ((this.getPage() / 10) > 0) {
                if (this.getPage() % 10 == 9) {
                    pageEnd = ((this.getPage() + 1) / 10) * 10 + 8;
                } else {
                    pageEnd = (this.getPage() / 10) * 10 + 9;
                }
            } else {
                pageEnd = (this.getPage() / 10) * 10 + 10;
            }
            if (pageEnd > this.getTotalPages()) {
                pageEnd = this.getTotalPages();
            }
        } else {
            pageEnd = this.getTotalPages();
        }
        return pageEnd;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page >= totalPages) {
            this.page = totalPages;
        } else if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
