
package com.example.workshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FullDatabase extends SQLiteOpenHelper {
    // declare require values
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "FullDatabase";
    private SQLiteDatabase db;
    //private static final String TABLE_NAME = "SimpleTable";

    public FullDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    // declare table column names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PRENOM = "prenom";
    private static final String KEY_INFOS = "infos";
    private static final String KEY_RELATION = "relation";
    private static final String KEY_PHOTO = "photo";
    private static final String KEY_TEL = "telephone";





    // creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createContacts = "CREATE TABLE "+"Contacts"+" ("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_NOM+" TEXT,"+
                KEY_PRENOM+" TEXT,"+
                KEY_INFOS+" TEXT,"+
                KEY_RELATION+" TEXT,"+
                KEY_PHOTO+" TEXT,"+
                KEY_TEL+" TEXT"
                +" )";
        db.execSQL(createContacts);
        String createInfos = "CREATE TABLE "+"Infos"+" ("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_TITLE+" TEXT,"+
                KEY_CONTENT+" TEXT"
                +" )";
        db.execSQL(createInfos);
        String createJournal = "CREATE TABLE "+"Journal"+" ("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_CONTENT+" TEXT,"+
                KEY_DATE+" TEXT,"+
                KEY_TIME+" TEXT"
                +" )";
        db.execSQL(createJournal);
    }

    // upgrade db if older version exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion)
            return;

        db.execSQL("DROP TABLE IF EXISTS "+"createInfos");
        db.execSQL("DROP TABLE IF EXISTS "+"createJournal");
        db.execSQL("DROP TABLE IF EXISTS "+"createContacts");
        onCreate(db);
    }

    /////////////////////////////////////              ADD                  //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public long addNoteInfos(NoteInfos note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_TITLE,note.getTitle());
        v.put(KEY_CONTENT,note.getContent());
        // inserting data into db
        long ID = db.insert("Infos",null,v);
        return  ID;
    }
    public long addNoteContacts(NoteContacts note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_NOM,note.getNom());
        v.put(KEY_PRENOM,note.getPrenom());
        v.put(KEY_INFOS,note.getInfos());
        v.put(KEY_RELATION,note.getRelation());
        v.put(KEY_PHOTO,note.getPhoto());
        v.put(KEY_TEL,note.getTel());
        // inserting data into db
        long ID = db.insert("Contacts",null,v);
        return  ID;
    }
    public long addNoteJournal(NoteJournal note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(KEY_DATE,note.getDate());
        v.put(KEY_CONTENT,note.getContent());
        v.put(KEY_TIME,note.getTime());
        // inserting data into db
        long ID = db.insert("Journal",null,v);
        return  ID;
    }

    /////////////////////////////////////              GET                  /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //notes des infos
    public NoteInfos getNoteInfos(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] query = new String[] {KEY_ID,KEY_TITLE,KEY_CONTENT};
        Cursor cursor=  db.query("Infos",query,KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        return new NoteInfos(
                Long.parseLong(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2));
    }
    //notes des contacts
    public NoteContacts getNoteContacts(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] query = new String[] {KEY_ID,KEY_NOM,KEY_PRENOM,KEY_PHOTO,KEY_TEL,KEY_INFOS,KEY_RELATION};
        Cursor cursor=  db.query("Contacts",query,KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        return new NoteContacts(
                Long.parseLong(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));
    }
    //notes du journal
    public NoteJournal getNoteJournal(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] query = new String[] {KEY_ID,KEY_DATE,KEY_CONTENT,KEY_TIME};
        Cursor cursor=  db.query("Journal",query,KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        return new NoteJournal(
                Long.parseLong(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
    }

    /////////////////////////////////////              GET ALL              /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<NoteInfos> getAllNotesInfos(){
        List<NoteInfos> allNotes = new ArrayList<>();
        String query = "SELECT * FROM " + "Infos"+" ORDER BY "+KEY_ID+" DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                NoteInfos note = new NoteInfos();
                note.setId(Long.parseLong(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                allNotes.add(note);
            }while (cursor.moveToNext());
        }

        return allNotes;

    }
    public List<NoteContacts> getAllNotesContacts(){
        List<NoteContacts> allNotes = new ArrayList<>();
        String query = "SELECT * FROM " + "Contacts"+" ORDER BY "+KEY_ID+" DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                NoteContacts note = new NoteContacts();
                note.setId(Long.parseLong(cursor.getString(0)));
                note.setNom(cursor.getString(1));
                note.setPrenom(cursor.getString(2));
                note.setInfos(cursor.getString(3));
                note.setRelation(cursor.getString(4));
                note.setPhoto(cursor.getString(5));
                note.setTel(cursor.getString(6));
                allNotes.add(note);
            }while (cursor.moveToNext());
        }

        return allNotes;

    }
    public List<NoteJournal> getAllNotesJournal(){
        List<NoteJournal> allNotes = new ArrayList<>();
        String query = "SELECT * FROM " + "Journal"+" ORDER BY "+KEY_ID+" DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                NoteJournal note = new NoteJournal();
                note.setId(Long.parseLong(cursor.getString(0)));
                note.setContent(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setTime(cursor.getString(4));
                allNotes.add(note);
            }while (cursor.moveToNext());
        }

        return allNotes;

    }

    /////////////////////////////////////              EDIT                 /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int editNoteInfos(NoteInfos note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        Log.d("Edited", "Edited Title: -> "+ note.getTitle() + "\n ID -> "+note.getId());
        c.put(KEY_TITLE,note.getTitle());
        c.put(KEY_CONTENT,note.getContent());
        return db.update("Infos",c,KEY_ID+"=?",new String[]{String.valueOf(note.getId())});
    }

    public int editNoteJournal(NoteJournal note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        Log.d("Edited", "Edited Content: -> "+ note.getContent() + "\n ID -> "+note.getId());
        c.put(KEY_CONTENT,note.getContent());
        c.put(KEY_DATE,note.getDate());
        c.put(KEY_TIME,note.getTime());
        return db.update("Journal",c,KEY_ID+"=?",new String[]{String.valueOf(note.getId())});
    }

    public int editNoteContacts(NoteContacts note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        Log.d("Edited", "Edited Nom: -> "+ note.getNom() + "\n ID -> "+note.getId());
        c.put(KEY_NOM,note.getNom());
        c.put(KEY_PRENOM,note.getPrenom());
        c.put(KEY_INFOS,note.getInfos());
        c.put(KEY_RELATION,note.getRelation());
        c.put(KEY_PHOTO,note.getPhoto());
        c.put(KEY_TEL,note.getTel());
        return db.update("Contacts",c,KEY_ID+"=?",new String[]{String.valueOf(note.getId())});
    }

    /////////////////////////////////////              DELETE               ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    void deleteNoteInfos(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Infos",KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    void deleteNoteJournal(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Journal",KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    void deleteNoteContacts(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Contacts",KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

}