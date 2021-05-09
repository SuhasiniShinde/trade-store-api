package com.tradestore.model.dto;

import com.tradestore.validation.ValidMaturityDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ssg228 on 9/5/21.
 */
public class TradeStoreRequest {

    @NotBlank(message = "TradeId should not be blank")
    private String tradeId;

    @NotBlank(message = "CounterPartyId should not be blank")
    private String counterPartyId;

    @NotNull(message = "Version should not be blank")
    @Digits(integer = 5, fraction = 0)
    private Integer version;

    @NotBlank(message = "bookId should not be blank")
    private String bookId;

    /*@NotNull(message = "MaturityDate should not be blank")*/
    @ValidMaturityDate
    private Date maturityDate;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

}
