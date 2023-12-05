package io.payeah.sdk.request;

import lombok.Data;
import java.util.Date;

/**
 * CardOpsQry
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card ops query request body
 **/
@Data
public class CardOpsQry {

    /**
     * [Conditional] User Request Number
     * String type (Maximum length: 128)
     * Unique order number
     */
    private String clientOrderId;

    /**
     * [Conditional] Card Unique Identifier
     * String type (Maximum length: 128)
     */
    private String cardId;

    /**
     * [Conditional] Shared Card Group Unique Identifier
     * String type (Maximum length: 128)
     */
    private String groupId;

    /**
     * [Conditional] Order Status
     * Integer type
     * Status: 0 Pending 1 Processing 2 Success 3 Failed
     */
    private Integer status;

    /**
     * [Conditional] Order Type
     * Integer type
     * Type: 0#Card Creation 1#Top Up 3#Card Closure 4#Refund
     */
    private Integer opType;

    /**
     * [Conditional] Start Time for Transactions
     * String type
     * Format: yyyy-MM-dd
     */
    private Date beginTime;

    /**
     * [Conditional] End Time for Transactions
     * String type
     * Format: yyyy-MM-dd
     */
    private Date endTime;

    /**
     * [Mandatory] Current Page
     * Integer type
     * Positive integer
     */
    private Integer currentPage;

    /**
     * [Mandatory] Page Size
     * Integer type
     * Maximum 50
     */
    private Integer pageSize;
}