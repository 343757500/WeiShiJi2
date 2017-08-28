package com.micro.weishiji.takeout.db.greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cartGoodsDaoConfig;
    private final DaoConfig addressDaoConfig;

    private final CartGoodsDao cartGoodsDao;
    private final AddressDao addressDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cartGoodsDaoConfig = daoConfigMap.get(CartGoodsDao.class).clone();
        cartGoodsDaoConfig.initIdentityScope(type);

        addressDaoConfig = daoConfigMap.get(AddressDao.class).clone();
        addressDaoConfig.initIdentityScope(type);

        cartGoodsDao = new CartGoodsDao(cartGoodsDaoConfig, this);
        addressDao = new AddressDao(addressDaoConfig, this);

        registerDao(CartGoods.class, cartGoodsDao);
        registerDao(Address.class, addressDao);
    }
    
    public void clear() {
        cartGoodsDaoConfig.getIdentityScope().clear();
        addressDaoConfig.getIdentityScope().clear();
    }

    public CartGoodsDao getCartGoodsDao() {
        return cartGoodsDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

}
