package com.huanghuai.djt.dongjitang.Gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PRODUCT__GOODS".
*/
public class Product_GoodsDao extends AbstractDao<Product_Goods, Long> {

    public static final String TABLENAME = "PRODUCT__GOODS";

    /**
     * Properties of entity Product_Goods.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Price = new Property(2, String.class, "price", false, "PRICE");
        public final static Property Comment = new Property(3, String.class, "comment", false, "COMMENT");
        public final static Property Label = new Property(4, int.class, "label", false, "LABEL");
        public final static Property Count = new Property(5, int.class, "count", false, "COUNT");
        public final static Property Details = new Property(6, String.class, "details", false, "DETAILS");
        public final static Property Explain = new Property(7, String.class, "explain", false, "EXPLAIN");
        public final static Property Evaluate = new Property(8, String.class, "evaluate", false, "EVALUATE");
        public final static Property Prescription = new Property(9, boolean.class, "prescription", false, "PRESCRIPTION");
        public final static Property Classification = new Property(10, String.class, "classification", false, "CLASSIFICATION");
    }


    public Product_GoodsDao(DaoConfig config) {
        super(config);
    }
    
    public Product_GoodsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PRODUCT__GOODS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"PRICE\" TEXT," + // 2: price
                "\"COMMENT\" TEXT," + // 3: comment
                "\"LABEL\" INTEGER NOT NULL ," + // 4: label
                "\"COUNT\" INTEGER NOT NULL ," + // 5: count
                "\"DETAILS\" TEXT," + // 6: details
                "\"EXPLAIN\" TEXT," + // 7: explain
                "\"EVALUATE\" TEXT," + // 8: evaluate
                "\"PRESCRIPTION\" INTEGER NOT NULL ," + // 9: prescription
                "\"CLASSIFICATION\" TEXT);"); // 10: classification
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PRODUCT__GOODS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Product_Goods entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(3, price);
        }
 
        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(4, comment);
        }
        stmt.bindLong(5, entity.getLabel());
        stmt.bindLong(6, entity.getCount());
 
        String details = entity.getDetails();
        if (details != null) {
            stmt.bindString(7, details);
        }
 
        String explain = entity.getExplain();
        if (explain != null) {
            stmt.bindString(8, explain);
        }
 
        String evaluate = entity.getEvaluate();
        if (evaluate != null) {
            stmt.bindString(9, evaluate);
        }
        stmt.bindLong(10, entity.getPrescription() ? 1L: 0L);
 
        String classification = entity.getClassification();
        if (classification != null) {
            stmt.bindString(11, classification);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Product_Goods entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(3, price);
        }
 
        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(4, comment);
        }
        stmt.bindLong(5, entity.getLabel());
        stmt.bindLong(6, entity.getCount());
 
        String details = entity.getDetails();
        if (details != null) {
            stmt.bindString(7, details);
        }
 
        String explain = entity.getExplain();
        if (explain != null) {
            stmt.bindString(8, explain);
        }
 
        String evaluate = entity.getEvaluate();
        if (evaluate != null) {
            stmt.bindString(9, evaluate);
        }
        stmt.bindLong(10, entity.getPrescription() ? 1L: 0L);
 
        String classification = entity.getClassification();
        if (classification != null) {
            stmt.bindString(11, classification);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Product_Goods readEntity(Cursor cursor, int offset) {
        Product_Goods entity = new Product_Goods( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // price
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // comment
            cursor.getInt(offset + 4), // label
            cursor.getInt(offset + 5), // count
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // details
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // explain
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // evaluate
            cursor.getShort(offset + 9) != 0, // prescription
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // classification
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Product_Goods entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrice(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setComment(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLabel(cursor.getInt(offset + 4));
        entity.setCount(cursor.getInt(offset + 5));
        entity.setDetails(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setExplain(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setEvaluate(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPrescription(cursor.getShort(offset + 9) != 0);
        entity.setClassification(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Product_Goods entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Product_Goods entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Product_Goods entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
