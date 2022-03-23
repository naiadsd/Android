package com.example.naiadsd.room;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class CustomerDAO_Impl implements CustomerDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCustomerTable;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CustomerDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomerTable = new EntityInsertionAdapter<CustomerTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CustomerTable`(`id`,`CustomerId`,`CustomerName`,`ShiptoAddressLineOne`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomerTable value) {
        stmt.bindLong(1, value.id);
        if (value.CustomerId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.CustomerId);
        }
        if (value.CustomerName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.CustomerName);
        }
        if (value.ShiptoAddressLineOne == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.ShiptoAddressLineOne);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CustomerTable";
        return _query;
      }
    };
  }

  @Override
  public void insert(CustomerTable customerTable) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomerTable.insert(customerTable);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<CustomerTable> getAll() {
    final String _sql = "SELECT * FROM CustomerTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCustomerId = _cursor.getColumnIndexOrThrow("CustomerId");
      final int _cursorIndexOfCustomerName = _cursor.getColumnIndexOrThrow("CustomerName");
      final int _cursorIndexOfShiptoAddressLineOne = _cursor.getColumnIndexOrThrow("ShiptoAddressLineOne");
      final List<CustomerTable> _result = new ArrayList<CustomerTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerTable _item;
        _item = new CustomerTable();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.CustomerId = _cursor.getString(_cursorIndexOfCustomerId);
        _item.CustomerName = _cursor.getString(_cursorIndexOfCustomerName);
        _item.ShiptoAddressLineOne = _cursor.getString(_cursorIndexOfShiptoAddressLineOne);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CustomerTable> getAllSustomersByString(String newText) {
    final String _sql = "SELECT * FROM CustomerTable where (CustomerName Like '%'|| ? ||'%')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (newText == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, newText);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCustomerId = _cursor.getColumnIndexOrThrow("CustomerId");
      final int _cursorIndexOfCustomerName = _cursor.getColumnIndexOrThrow("CustomerName");
      final int _cursorIndexOfShiptoAddressLineOne = _cursor.getColumnIndexOrThrow("ShiptoAddressLineOne");
      final List<CustomerTable> _result = new ArrayList<CustomerTable>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CustomerTable _item;
        _item = new CustomerTable();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.CustomerId = _cursor.getString(_cursorIndexOfCustomerId);
        _item.CustomerName = _cursor.getString(_cursorIndexOfCustomerName);
        _item.ShiptoAddressLineOne = _cursor.getString(_cursorIndexOfShiptoAddressLineOne);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
