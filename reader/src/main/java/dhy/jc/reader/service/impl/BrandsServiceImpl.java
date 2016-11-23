package dhy.jc.reader.service.impl;

import dhy.jc.reader.dao.BrandsDao;
import dhy.jc.reader.model.Brands;
import dhy.jc.reader.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/18.
 */
@Service("brandsService")
public class BrandsServiceImpl extends BaseServiceImpl<Brands> implements BrandsService {

    @Autowired
    private BrandsDao brandsDao;

    /**
     * 获取具体dao类
     */
    @Autowired
    public void setBaseDao() {
        super.setBaseDao(brandsDao);
    }

}
