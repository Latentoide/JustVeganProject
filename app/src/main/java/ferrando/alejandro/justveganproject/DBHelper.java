package ferrando.alejandro.justveganproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ferrando.alejandro.justveganproject.model.User;

public class DBHelper extends SQLiteOpenHelper {
    public static final String NAME_DB = "justVegan.db";

    public DBHelper(Context context){
        super(context, NAME_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email TEXT PRIMARY KEY, contrasenya TEXT, trabajador INTEGER, admin INTEGER)");
        db.execSQL("CREATE TABLE restaurantes(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, descripcion TEXT, lugar TEXT)");
        db.execSQL("CREATE TABLE platos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, descripcion TEXT, precio REAL, idRestaurante INTEGER, FOREIGN KEY (idRestaurante) REFERENCES restaurantes(id))");
        db.execSQL("CREATE TABLE factura(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, idCliente INTEGER, precio REAL, FOREIGN KEY (idCliente) REFERENCES user(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists restaurantes");
        db.execSQL("drop table if exists platos");
        db.execSQL("drop table if exists factura");
    }

    public boolean isAdmin(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select admin from user where email=?", new String[]{email});
        if(cursor.moveToFirst()){
            int isRoot = cursor.getInt(0);
            db.close();
            return isRoot == 1;
        }
        return false;
    }

    public boolean isWorker(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select trabajador from user where email=?", new String[]{email});
        if(cursor.moveToFirst()){
            int isRoot = cursor.getInt(0);
            db.close();
            return isRoot == 1;
        }
        return false;
    }

    public Boolean insertarUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("email", user.getEmail());
        cv.put("admin", user.getAdmin());
        cv.put("trabajador", user.getTrabajador());
        cv.put("contrasenya", user.getPassword());

        long hecho = db.insert("user", null, cv);
        db.close();

        return hecho >= 0;
    }

    public Boolean existeUser(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and contrasenya = ?", new String[]{email, password});
        if(cursor.moveToFirst()){
            int exists = cursor.getCount();
            db.close();
            return exists > 0;
        }

        return false;
    }
}
