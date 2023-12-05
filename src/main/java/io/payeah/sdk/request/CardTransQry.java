package io.payeah.sdk.request;

import lombok.Data;
import java.util.Date;

/**
 * CardTransQry
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card transaction query request body
 **/
@Data
public class CardTransQry {

    /**
     * [Optional] Card Unique Identifier
     * String type
     * Optional, unique card ID
     */
    private String cardId;

    /**
     * [Conditional] Begin Time
     * String type
     * Format: yyyy-MM-dd (Transaction date and transaction creation date cannot be empty at the same time)
     */
    private Date beginTime;

    /**
     * [Conditional] End Time
     * String type
     * Format: yyyy-MM-dd (Transaction date and transaction creation date cannot be empty at the same time)
     */
    private Date endTime;

    /**
     * [Conditional] Create Date Start
     * String type
     * Format: yyyy-MM-dd (Transaction date and transaction creation date cannot be empty at the same time)
     */
    private Date createDateStart;

    /**
     * [Conditional] Create Date End
     * String type
     * Format: yyyy-MM-dd (Transaction date and transaction creation date cannot be empty at the same time)
     */
    private Date createDateEnd;

    /**
     * [Mandatory] Current Page
     * Integer type
     * Positive integer
     */
    private int currentPage;

    /**
     * [Mandatory] Page Size
     * Integer type
     * Maximum 50
     */
    private int pageSize;

    /**
     * [Mandatory] Card Type
     * String type
     * 1: Normal Card 2: Shared Card
     */
    private Integer cardType = 1;
}