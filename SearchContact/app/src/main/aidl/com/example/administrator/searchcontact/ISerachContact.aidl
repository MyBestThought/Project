// ISerachContact.aidl
package com.example.administrator.searchcontact;

// Declare any non-default types here with import statements

interface ISerachContact {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    MyContact SearchContact(String contactName);
}
