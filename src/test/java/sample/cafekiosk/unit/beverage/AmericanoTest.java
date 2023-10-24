package sample.cafekiosk.unit.beverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AmericanoTest {

    @Test
    @DisplayName("이름 테스트")
    void getName() {
        Americano americano = new Americano();

        // Junit
        assertEquals(americano.getName(), "아메리카노");
        // AssertJ
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    @DisplayName("가격 테스트")
    void getPrice() {
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);
    }
}