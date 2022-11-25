package rocks.basset.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rocks.basset.sfgpetclinic.fauxspring.Model;
import rocks.basset.sfgpetclinic.fauxspring.ModelMapImpl;
import rocks.basset.sfgpetclinic.model.Speciality;
import rocks.basset.sfgpetclinic.model.Vet;
import rocks.basset.sfgpetclinic.services.SpecialtyService;
import rocks.basset.sfgpetclinic.services.VetService;
import rocks.basset.sfgpetclinic.services.map.SpecialityMapService;
import rocks.basset.sfgpetclinic.services.map.VetMapService;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("controllers")
class VetControllerTest {

    VetController controller;

    VetService service;

    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
        controller = new VetController(service);
    }

    @Test
    @DisplayName("Should throw NullPointerException")
    void listVetsShouldThrowNullPointerException() {
        Model model = null;
        assertThrows(NullPointerException.class, () -> {
            controller.listVets(model);
        }, "No NullPointerException thrown");
    }

    @Test
    @DisplayName("List should be empty")
    void listVetsListShouldBeEmpty() {
        Model model = new ModelMapImpl();

        assertAll("Vet controller listVets tests",
                () -> {
                    assertThat(controller.listVets(model)).isEqualTo("vets/index");
                },
                () -> {
                    controller.listVets(model);
                    Object o = ((ModelMapImpl) model).getAttribute("vets");
                    Set<Vet> vets = (HashSet<Vet>) o;
                    assertThat(vets).hasSize(0);
                }
        );
    }

    @Test
    @DisplayName("List should not be empty")
    void listVetsListShouldNotBeEmpty() {
        Model model = new ModelMapImpl();
        Set<Speciality> specialities1 = new HashSet<>();
        specialities1.add(new Speciality(1l, "Spec1"));
        Set<Speciality> specialities2 = new HashSet<>();
        specialities2.add(new Speciality(2l, "Spec2"));

        Vet vet1 = new Vet(1L, "Thomas", "Basset", specialities1);
        Vet vet2 = new Vet(2L, "Joe", "Buck", specialities2);

        service.save(vet1);
        service.save(vet2);

        assertAll("Vet controller listVets tests",
                () -> {
                    assertThat(controller.listVets(model)).isEqualTo("vets/index");
                },
                () -> {
                    controller.listVets(model);
                    Object o = ((ModelMapImpl) model).getAttribute("vets");
                    Set<Vet> vets = (HashSet<Vet>) o;
                    assertAll("Vets list",
                            () -> assertThat(vets).hasSize(2)
                    );
                }
        );
    }
}
