package com.example.naiadsd.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CustomerDAO _customerDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomerTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `CustomerId` TEXT, `CustomerName` TEXT, `ShiptoAddressLineOne` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"70acd2257d022c16068e77da7954f167\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `CustomerTable`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCustomerTable = new HashMap<String, TableInfo.Column>(4);
        _columnsCustomerTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCustomerTable.put("CustomerId", new TableInfo.Column("CustomerId", "TEXT", false, 0));
        _columnsCustomerTable.put("CustomerName", new TableInfo.Column("CustomerName", "TEXT", false, 0));
        _columnsCustomerTable.put("ShiptoAddressLineOne", new TableInfo.Column("ShiptoAddressLineOne", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomerTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomerTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomerTable = new TableInfo("CustomerTable", _columnsCustomerTable, _foreignKeysCustomerTable, _indicesCustomerTable);
        final TableInfo _existingCustomerTable = TableInfo.read(_db, "CustomerTable");
        if (! _infoCustomerTable.equals(_existingCustomerTable)) {
          throw new IllegalStateException("Migration didn't properly handle CustomerTable(com.example.naiadsd.room.CustomerTable).\n"
                  + " Expected:\n" + _infoCustomerTable + "\n"
                  + " Found:\n" + _existingCustomerTable);
        }
      }
    }, "70acd2257d022c16068e77da7954f167", "a7d2eec64a33ce0bd16502567027360d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "CustomerTable");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `CustomerTable`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CustomerDAO getCustomerDAO() {
    if (_customerDAO != null) {
      return _customerDAO;
    } else {
      synchronized(this) {
        if(_customerDAO == null) {
          _customerDAO = new CustomerDAO_Impl(this);
        }
        return _customerDAO;
      }
    }
  }
}
