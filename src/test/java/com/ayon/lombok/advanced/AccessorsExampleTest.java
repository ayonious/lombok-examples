package com.ayon.lombok.advanced;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class AccessorsExampleTest {

    @Test
    void testFluentAccessors() {
        AccessorsExample example = new AccessorsExample()
            .name("John Doe")
            .age(30)
            .email("john@example.com");

        assertThat(example.name()).isEqualTo("John Doe");
        assertThat(example.age()).isEqualTo(30);
        assertThat(example.email()).isEqualTo("john@example.com");
    }

    @Test
    void testFluentChainingReturnsThis() {
        AccessorsExample example = new AccessorsExample();

        AccessorsExample result = example
            .name("Jane")
            .age(25)
            .email("jane@example.com");

        assertThat(result).isSameAs(example);
    }
}

class ChainedAccessorsTest {

    @Test
    void testChainedSetters() {
        ChainedAccessors obj = new ChainedAccessors()
            .setFirstName("Jane")
            .setLastName("Smith")
            .setScore(95);

        assertThat(obj.getFirstName()).isEqualTo("Jane");
        assertThat(obj.getLastName()).isEqualTo("Smith");
        assertThat(obj.getScore()).isEqualTo(95);
    }

    @Test
    void testChainedSettersReturnThis() {
        ChainedAccessors obj = new ChainedAccessors();

        ChainedAccessors result = obj
            .setFirstName("Bob")
            .setLastName("Jones");

        assertThat(result).isSameAs(obj);
    }
}

class PrefixedAccessorsTest {

    @Test
    void testPrefixedFields() {
        PrefixedAccessors obj = new PrefixedAccessors();
        obj.setName("Bob");
        obj.setAge(25);
        obj.setActive(true);
        obj.setEmail("bob@example.com");

        assertThat(obj.getName()).isEqualTo("Bob");
        assertThat(obj.getAge()).isEqualTo(25);
        assertThat(obj.isActive()).isTrue();
        assertThat(obj.getEmail()).isEqualTo("bob@example.com");
    }
}

class CombinedAccessorsTest {

    @Test
    void testCombinedAccessors() {
        CombinedAccessors obj = new CombinedAccessors()
            .id("ID-001")
            .type("Premium")
            .value(99.99);

        assertThat(obj.id()).isEqualTo("ID-001");
        assertThat(obj.type()).isEqualTo("Premium");
        assertThat(obj.value()).isEqualTo(99.99);
    }

    @Test
    void testInitializeMethod() {
        CombinedAccessors obj = new CombinedAccessors().initialize();

        assertThat(obj.id()).isEqualTo("ID-001");
        assertThat(obj.type()).isEqualTo("Premium");
        assertThat(obj.value()).isEqualTo(99.99);
    }
}