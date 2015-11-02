package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.ContactDetails;

import java.util.Map;

/**
 * Created by SHANE on 2015/05/04.
 */
public class ContactFactory {
    public static ContactDetails createContactDetails(Map<String,String> values)
    {
        ContactDetails contact=new ContactDetails
                .Builder(values.get("tel"))
                //.email(values.get("mail"))
                .address(values.get("address"))
                .build();
        return contact;
    }
}
