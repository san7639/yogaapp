package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;

import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

@Autowired
    private MockMvc mockMvc;

//DAY 3 -Directory check
@Test
@Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
	@Order(2)

    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
	@Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
	@Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }  

	//Day 4 File Check for Model

	@Test
	@Order(5)
    void Day4_test_AttendanceModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Attendance.java").isFile());
    }

	@Test
	@Order(6)
    void Day4_test_MemberModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Member.java").isFile());
    }

	@Test
	@Order(7)

    void Day4_test_MembershipModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Membership.java").isFile());
    }

	@Test
	@Order(8)
    void Day4_test_MembershipType_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/MembershipType.java").isFile());
    }

	@Test
	@Order(9)
    void Day4_test_Payment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Payment.java").isFile());
    }

@Test
@Order(10)
void Day4_test_Payment_Has_Entity_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.Payment");
        Class<?> annotation = Class.forName("jakarta.persistence.Entity");

        assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Entity annotation is missing on Payment class");

    } catch (ClassNotFoundException e) {
        fail("❌ Payment class not found.");
    } catch (Exception e) {
        fail("❌ Unable to check @Entity annotation on Payment.");
    }
}

@Test
@Order(11)

void Day4_test_Payment_Has_Id_Annotation_On_Field() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.Payment");
        Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");

        boolean found = false;

        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No field in Payment class is annotated with @Id");

    } catch (ClassNotFoundException e) {
        fail("❌ Payment class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @Id annotation in Payment class.");
    }
}

	//Day 5 Tetscases for Repository
	@Test
	@Order(12)

    void Day5_testAttendanceRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/AttendanceRepository.java").isFile());
    }

	@Test
	@Order(13)
    void Day5_testMemberRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/MemberRepository.java").isFile());
    }

	@Test
	@Order(14)
    void Day5_testMembershipRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/MembershipRepository.java").isFile());
    }


	@Test
	@Order(15)
    void Day5_testMembershipTypeRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/MembershipTypeRepository.java").isFile());
    }

	@Test
	@Order(16)
    void Day5_testPaymentRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/PaymentRepository.java").isFile());
    }


	@Test
	@Order(17)
    void Day5_test_PaymentRepository_Has_Repository_Annotation() {
        try {
            // Load PaymentRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.PaymentRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on PaymentRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ PaymentRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on PaymentRepository.");
        }
    }


	@Test
	@Order(18)
    void Day5_test_MemberRepository_Has_Repository_Annotation() {
        try {
            // Load ProductRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.MemberRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on MemberRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ MemberRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on MemberRepository.");
        }
    }
 
    //Day-6 Check Controller

	@Test
	@Order(19)
    void Day6_test_AttendanceController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/AttendanceController.java").isFile());
    }


	@Test
	@Order(20)
    void Day6_test_MemberController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/MemberController.java").isFile());
    }

	@Test
	@Order(21)
    void Day6_test_MembershipController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/MembershipController.java").isFile());
    }

	
	@Test
	@Order(22)
    void Day6_test_MembershipTypeController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/MembershipTypeController.java").isFile());
    }

	@Test
	@Order(23)
    void Day6_test_PaymentController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/PaymentController.java").isFile());
    }


	@Test
	@Order(24)
    void Day6_test_PaymentController_Has_RestController_Annotation() {
        try {
            // Load ProductRepo class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.controller.PaymentController");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");



            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @RestController annotation is missing on PaymentController class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ StockEntry class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on PaymentController.");
        }
    }

	
@Test
@Order(25)
void Day6_test_MemberController_Has_RestController_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.MemberController");
        Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @RestController annotation is missing on MemberController class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ MemberController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RestController annotation on MemberController.");
    }
}
//Day-7 Controller
	@Test
	@Order(26)
    void Day7_test_AttendanceController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.AttendanceController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on AttendanceController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ AttendanceController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in AttendanceController.");
        }
    }


	@Test
	@Order(27)

    void Day7_test_AttendanceController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.AttendanceController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of AttendanceController");

        } catch (ClassNotFoundException e) {
            fail("❌ AttendanceController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in AttendanceController.");
        }
    }


	@Test
	@Order(28)
    void Day7_test_MemberController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.MemberController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on MemberController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ MemberController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in MemberController.");
        }
    }


    @Test
	@Order(29)
    void Day7_test_MembershipController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.MembershipController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on MembershipController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ MembershipController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in MembershipController.");
        }
    }



	@Test
	@Order(30)
    void Day7_test_MembershipController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.MembershipController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of MembershipController");

        } catch (ClassNotFoundException e) {
            fail("❌ MembershipController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in MembershipController.");
        }
    }


    @Test
	@Order(31)
    void Day7_test_MembershipTypeController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.MembershipTypeController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of MembershipTypeController");

        } catch (ClassNotFoundException e) {
            fail("❌ MembershipTypeController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in MembershipTypeController.");
        }
    }


    @Test
	@Order(32)
    void Day7_test_Payment_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.PaymentController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on PaymentController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ PaymentController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in PaymentController.");
        }
    }

//Day-8 Check Service
	@Test
	@Order(33)
    void Day8_test_AttendanceService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/AttendanceService.java").isFile());
    }

@Test
@Order(34)

void Day8_test_MemberService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/MemberService.java").isFile());
}

@Test
@Order(35)

void Day8_test_MembershipService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/MembershipService.java").isFile());
}

@Test
@Order(36)

void Day8_test_MembershipTypeService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/MembershipTypeService.java").isFile());
}


@Test
@Order(37)

void Day8_test_PaymentService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/PaymentService.java").isFile());
}


@Test
@Order(38)
void Day8_test_PaymentServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/PaymentServiceImpl.java").isFile());
}

@Test
@Order(39)

void Day8_test_MemberServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/MemberServiceImpl.java").isFile());
}

//Day9

@Test
@Order(40)
public void Day9_testPagination_ReturnsArray() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/members/page/0/5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
}

@Test
@Order(41)
public void Day9_testPagination_NotEmptyOrEmptyAllowed() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/members/page/0/5"))
            .andExpect(status().isOk());
}
 

@Test
@Order(42)
public void Day9_testPagination_ArrayReturned() throws Exception {
    mockMvc.perform(get("/api/members/page/0/5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
}

@Test
@Order(43)
public void Day9_testPagination_MaxSizeCheck() throws Exception {
    mockMvc.perform(get("/api/members/page/0/5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(org.hamcrest.Matchers.lessThanOrEqualTo(5)));
}
@Test
@Order(44)
public void Day9_testPagination_AlwaysArray() throws Exception {
    mockMvc.perform(get("/api/members/page/10/5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
}

//Day-10  
@Test
@Order(45)
public void Day10_testCreateMember_Positive() throws Exception {
    String json = "{ \"name\": \"John\", \"email\": \"john@gmail.com\" }";

    mockMvc.perform(post("/api/members")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("John"));
}
@Test
@Order(46)
public void Day10_testGetMemberById_Positive() throws Exception {
    mockMvc.perform(get("/api/members/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").exists())
            .andExpect(jsonPath("$.email").exists());
}

@Test
@Order(47)
public void Day10_testUpdateMember_Positive() throws Exception {
    String json = "{ \"name\": \"Updated User\", \"email\": \"updated@gmail.com\" }";

    mockMvc.perform(put("/api/members/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated User"));
}
    @Test
    @Order(48)
    public void testCreateMembershipType_Positive() throws Exception {
        String json = "{ \"typeName\": \"Gold\", \"price\": 5000, \"durationInMonths\": 12 }";

        mockMvc.perform(post("/api/membership-types")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.typeId").exists())
                .andExpect(jsonPath("$.typeName").value("Gold"))
                .andExpect(jsonPath("$.price").value(5000))
                .andExpect(jsonPath("$.durationInMonths").value(12));
    }

   
    @Test
    @Order(49)
    public void testUpdateMembershipType_Positive() throws Exception {
        String json = "{ \"typeName\": \"Platinum\", \"price\": 10000, \"durationInMonths\": 24 }";

        mockMvc.perform(put("/api/membership-types/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.typeId").value(1))
                .andExpect(jsonPath("$.typeName").value("Platinum"))
                .andExpect(jsonPath("$.price").value(10000))
                .andExpect(jsonPath("$.durationInMonths").value(24));
    }

    @Test
    @Order(50)
    public void testGetAllMembershipTypes_Positive() throws Exception {
        mockMvc.perform(get("/api/membership-types")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].typeId").exists())
                .andExpect(jsonPath("$[0].typeName").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].durationInMonths").exists());
    }

   
    @Test
    @Order(51)
    public void testGetMembershipTypeById_Positive() throws Exception {
        mockMvc.perform(get("/api/membership-types/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.typeId").value(1))
                .andExpect(jsonPath("$.typeName").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.durationInMonths").exists());
    }


    //JPQL QUERY
    @Test
    @Order(52)
    public void testGetMembershipTypesByName() throws Exception {
        // First, create a membership type to ensure data exists
        String json = "{ \"typeName\": \"Premium\", \"price\": 5000, \"durationInMonths\": 12 }";
        mockMvc.perform(post("/api/membership-types")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    
        // Now test the JPQL query endpoint
        mockMvc.perform(get("/api/membership-types/name/Premium"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].typeName").value("Premium"))
                .andExpect(jsonPath("$[0].price").value(5000))
                .andExpect(jsonPath("$[0].durationInMonths").value(12));
    }
    
@Test
@Order(53)
public void testGetMembershipTypesByPriceRange() throws Exception {
    mockMvc.perform(get("/api/membership-types/price?min=4000&max=6000"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].price").isNumber());
}

@Test
@Order(54)
public void testGetMembershipTypesByDurationGreaterThan() throws Exception {
    mockMvc.perform(get("/api/membership-types/duration-greater/6"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].durationInMonths").value(org.hamcrest.Matchers.greaterThan(6)));
}

//Day-11  
@Test
@Order(55)
public void testGetMembershipTypesByPriceLessThan() throws Exception {
    // Step 1: Create a type
    String membershipTypeJson = "{ \"typeName\": \"Basic\", \"price\": 1500, \"durationInMonths\": 6 }";
    mockMvc.perform(post("/api/membership-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(membershipTypeJson))
            .andExpect(status().isCreated());

    // Step 2: Call the endpoint
    mockMvc.perform(get("/api/membership-types/price-less/2000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].price").value(org.hamcrest.Matchers.lessThan(2000.00)));
}

@Test
@Order(56)
public void Day12_testGetMembershipTypesByName() throws Exception {

    String json = "{ \"typeName\": \"Premium\", \"price\": 2500.0, \"durationInMonths\": 12 }";

    // Create data first
    mockMvc.perform(post("/api/membership-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated());

    // JPQL query test
    mockMvc.perform(get("/api/membership-types/name/Premium")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].typeName").value("Premium"))
            .andReturn();
}



@Test
@Order(57)
public void Day12_testGetMembershipTypesByName_NotFound() throws Exception {

    mockMvc.perform(get("/api/membership-types/name/UnknownType")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent())
            .andExpect(content().string("No membership types found"));
}


@Test
@Order(58)
public void Day12_testGetMembershipTypesByPriceRange() throws Exception {

    // Create data
    String json = "{ \"typeName\": \"Gold\", \"price\": 1800.0, \"durationInMonths\": 6 }";
    mockMvc.perform(post("/api/membership-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated());

    mockMvc.perform(get("/api/membership-types/price?min=1000&max=2000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[*].typeName", org.hamcrest.Matchers.hasItem("Gold")))
            .andExpect(jsonPath("$[*].price", org.hamcrest.Matchers.hasItem(1800.0)));
}

@Test
@Order(59)
public void Day12_testGetMembershipTypesByPriceLessThan_NotFound() throws Exception {

    mockMvc.perform(get("/api/membership-types/price-less/10")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent())
            .andExpect(content().string("No membership types found"));
}

@Test
@Order(60)
public void Day12_testGetMembershipTypesByDurationGreaterThan_NotFound() throws Exception {

    mockMvc.perform(get("/api/membership-types/duration-greater/48")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent())
            .andExpect(content().string("No membership types found with duration greater than 48"));
}

@Test
@Order(61)
public void Day12_testGetMembershipTypesByPriceLessThan() throws Exception {

    String json = "{ \"typeName\": \"Budget\", \"price\": 1200.0, \"durationInMonths\": 3 }";

    mockMvc.perform(post("/api/membership-types")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated());

    mockMvc.perform(get("/api/membership-types/price-less/2000")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].price").value(1500.0));
}

@Test
@Order(62)
    void Day13_test_execption_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }


	
@Test
@Order(63)
void Day13_test_GloabalEception_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
}


@Test
@Order(64)
    void Day14test_configuartion_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

@Test
@Order(65)
public void Day15_testAOPLogFileExists() {
    assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
}
}