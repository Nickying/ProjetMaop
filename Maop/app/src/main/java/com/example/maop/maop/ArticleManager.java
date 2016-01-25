package com.example.maop.maop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by guillaume on 19/01/2016.
 */
public class ArticleManager {
    private static final String TABLE_NAME = "article";
    public static final String KEY_IDARTICLE="idarticle";
    public static final String KEY_NOMARTICLE="nomarticle";
    public static final String KEY_CATEGORIE="id_categorie";
    public static final String KEY_PRIX="prix";
    public static final String KEY_DESCRIPTION="description";
    public static final String KEY_IMAGE="nomarticle";
    public static final String KEY_IDMAGASIN="idmagasin";
    public static final String CREATE_TABLE_ARTICLE = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_IDARTICLE+" INTEGER primary key," +
            " "+KEY_NOMARTICLE+" TEXT," +
            " "+KEY_CATEGORIE+" TEXT," +
            " "+KEY_PRIX+" REAL," +
            " "+KEY_DESCRIPTION+" TEXT," +
            " "+KEY_IMAGE+" TEXT," +
            " "+KEY_IDMAGASIN+" INTEGER," +
            ");";
    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public ArticleManager(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }




    public Article getArticle(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Article a=new Article();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_IDARTICLE+"="+id, null);
        if (c.moveToFirst()) {
            a.setIdarticle(c.getInt(c.getColumnIndex(KEY_IDARTICLE)));
            a.setNomarticle(c.getString(c.getColumnIndex(KEY_NOMARTICLE)));
            a.setCategorie(c.getString(c.getColumnIndex(KEY_CATEGORIE)));
            a.setPrix(c.getFloat(c.getColumnIndex(KEY_PRIX)));
            a.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
            a.setImage(c.getString(c.getColumnIndex(KEY_IMAGE)));
            a.setIdmagasin(c.getInt(c.getColumnIndex(KEY_IDMAGASIN)));
            c.close();
        }

        return a;
    }

    public Cursor getAnimaux() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }


	public long addListe(int idarticle,int quantité,int idmagasin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put("idligne", idarticle);
	values.put("quantité", quantité);
	values.put("idmagasin", idmagasin);

        // insert() retourne l'id du nouvel enregistrement ins�r�, ou -1 en cas d'erreur
        return db.insert("ligne",null,values);
        }

    public int modListe(int idligne,int quantité) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affect�es par la requ�te

        ContentValues values = new ContentValues();
        values.put("quantité", quantité);

        String where = "idligne"+" = ?";
        String[] whereArgs = {idligne+""};

        return db.update("ligne", values, where, whereArgs);
        }



    public int supListe(int idligne) {

        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affect�es par la clause WHERE, 0 sinon

	String where = "idligne"+" = ?";
        String[] whereArgs = {idligne+""};

        return db.delete("ligne", where, whereArgs);
        }
	



	public Cursor getListe(int idmagasin) {
        // s�lection de tous les enregistrements de la table
        return db.rawQuery("select nomarticle,quantité, (prix*quantité) as prix from article a ,ligne l where a.idarticle=l.idarticle and l.idmagasin="+idmagasin, null);
        }


	
	public Cursor getArticleMagasin(int idmagasin) {
        // s�lection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME+" where idmagasin"+idmagasin, null);
        }
	

	public Cursor getArticleCatégorie(int idmagasin,String catégorie) {
        // s�lection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME+" where idmagasin"+idmagasin+"  "+catégorie, null);
        }
	
	public Cursor getArticleid(String idarticle) {
        // s�lection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME+" where idarticle= "+idarticle, null);
        }





}
