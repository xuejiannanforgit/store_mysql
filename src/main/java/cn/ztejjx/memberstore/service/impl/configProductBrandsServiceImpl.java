package cn.ztejjx.memberstore.service.impl;
import cn.ztejjx.memberstore.service.configProductBrandsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class configProductBrandsServiceImpl implements configProductBrandsService {


}
