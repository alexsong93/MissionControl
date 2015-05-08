package com.example.missioncontrol;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "RA_Database";
	private static final String TABLE_CONTACTS = "RA_contacts";
	
	private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_PASS + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
	
	// Adding new contact
	public void addContact(RAContact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, contact.getName()); // Contact Name
	    values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number
	    values.put(KEY_EMAIL, contact.getEmail()); // Contact email
	    values.put(KEY_PASS, contact.getPassword()); // Contact password
	 
	    // Inserting Row
	    db.insert(TABLE_CONTACTS, null, values);
	}
	 
	// Getting single contact
	public RAContact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		 
	    Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
	            KEY_NAME, KEY_PH_NO, KEY_EMAIL, KEY_PASS }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    RAContact contact = new RAContact(Integer.parseInt(cursor.getString(0)),
	            cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
	    return contact;
	}
	 
	// Getting All Contacts
	public List<RAContact> getAllContacts() {
		List<RAContact> contactList = new ArrayList<RAContact>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            RAContact contact = new RAContact();
	            contact.setID(Integer.parseInt(cursor.getString(0)));
	            contact.setName(cursor.getString(1));
	            contact.setPhoneNumber(cursor.getString(2));
	            contact.setEmail(cursor.getString(3));
	            contact.setPassword(cursor.getString(4));
	            // Adding contact to list
	            contactList.add(contact);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return contactList;
	}
	 
	// Getting contacts Count
	public int getRAContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
	}
	// Updating single contact
	public int updateContact(RAContact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, contact.getName());
	    values.put(KEY_PH_NO, contact.getPhoneNumber());
	    values.put(KEY_EMAIL, contact.getEmail());
	    values.put(KEY_PASS, contact.getPassword());
	 
	    // updating row
	    return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
	            new String[] { String.valueOf(contact.getID()) });
	}
	 
	// Deleting single contact
	public void deleteContact(RAContact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
	            new String[] { String.valueOf(contact.getID()) });
	}
	
	

}
