package my.select.netData.up;

/**
 * Created by wpp on 2017/4/27.
 */
public class PageBase {
    // 当前页
    private Integer currentPage;
    // 总页数
    private Integer totalCount;
    // 偏移量
    private Integer offset;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage ;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
