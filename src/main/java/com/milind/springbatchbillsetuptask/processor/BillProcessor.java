package com.milind.springbatchbillsetuptask.processor;

import com.milind.springbatchbillsetuptask.domain.Bill;
import com.milind.springbatchbillsetuptask.domain.Usage;
import org.springframework.batch.item.ItemProcessor;

public class BillProcessor implements ItemProcessor<Usage, Bill> {

    @Override
    public Bill process(Usage usage) throws Exception {
        Double billAmount = usage.getDataUsage() * .001 + usage.getMins() * .01;
        return new Bill(usage.getId(), usage.getFirstName(), usage.getLastName(),
                usage.getDataUsage(), usage.getMins(), billAmount);
    }
}
