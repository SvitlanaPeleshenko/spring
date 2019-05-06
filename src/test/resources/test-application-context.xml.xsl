<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
      ">



    <import resource="application-context.xml" />

    <alias name="testDiscountService" alias="discountService" />
    <bean id="testDiscountService" class="ua.epam.spring.hometask.service.impl.DefaultDiscountService">
        <property name="discountStrategies">
            <list>
                <bean class="ua.epam.spring.hometask.service.strategy.impl.BirthdayDiscountStrategy"
                      p:withinDays="5"
                      p:discountValue="5" />
                <bean class="ua.epam.spring.hometask.service.strategy.impl.EveryXTicketDiscountStrategy"
                      p:number="2"
                      p:discountPercent="50" />
            </list>
        </property>
    </bean>

    <bean id="testInMemoryAuditoriumDao" name="auditoriumDao" class="ua.epam.spring.hometask.dao.impl.InMemoryAuditoriumDao">
        <constructor-arg>
            <set>
                <bean class="ua.epam.spring.hometask.domain.Auditorium"
                      p:code="test-auditorium-1"
                      p:name="Test Auditorium"
                      p:numberOfSeats="30"
                      p:vipSeats="1,2,3" />
            </set>
        </constructor-arg>
    </bean>

    <bean id="overrideStrategiesBookingService" name="bookingService" class="ua.epam.spring.hometask.service.impl.DefaultBookingService" >
        <property name="additionalPriceStrategy">
            <bean class="ua.epam.spring.hometask.service.strategy.impl.HighRatingEventPriceStrategy">
                <property name="highRatingMultiplier" >
                    <value>1.2D</value>
                </property>
            </bean>
        </property>
    </bean>

</beans>