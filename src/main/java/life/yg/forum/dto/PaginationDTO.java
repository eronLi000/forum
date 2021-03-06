package life.yg.forum.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * create by yigang 2020/12/21
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;//current page number
    private List<Integer> pages = new ArrayList<>(); //page number list
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //previous page show or not
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //next page show or not
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //first page show or not
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //last page show or not
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}