package coupon;

import com.bit.shop.dao.CouponRepository;
import com.bit.shop.domain.Coupon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

public class CouponInsertTest {
    Logger log = Logger.getLogger("CouponInsertTest");

    @Test
    @DisplayName("coupon insert test")
    void insert() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        couponRepository.insert(Coupon.builder()
                .memberId(3L)
                .name("name")
                .isUsed(true)
                .discountPolicy("h")
                .discountPolicy("k")
                .build());
    }

    @Test
    @DisplayName("coupon select test")
    void select() throws Exception {
        CouponRepository couponRepository = new CouponRepository();
        List<Coupon> all = couponRepository.getAll();
        log.info(all.get(0).getName());
        log.info("select all success");
    }
}
