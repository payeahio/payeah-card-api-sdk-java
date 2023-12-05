package io.payeah.sdk.response;

import lombok.Data;

import java.util.List;

/**
 * PageCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : page info
 **/
@Data
public class PageCO<T> {
    /**
     * [Mandatory] Total number of authorized transactions
     * Long type
     */
    private Long totalCount;

    /**
     * [Mandatory] Current page number
     * Integer type
     */
    private Integer currentPage;

    /**
     * [Mandatory] Page size
     * Integer type
     */
    private Integer pageSize;

    /**
     * [Mandatory] List of items
     * List type
     */
    private List<T> list;
}