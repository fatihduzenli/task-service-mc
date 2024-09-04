package com.cydeo.util;

public class SwaggerExamples {

    private SwaggerExamples() {
        // Private constructor to prevent instantiation
    }

    public static final String TASK_CREATE_REQUEST_EXAMPLE = "{\n" +
            "  \"taskCode\": \"TS000\",\n" +
            "  \"taskSubject\": \"Sample Task Subject\",\n" +
            "  \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "  \"taskStatus\": \"IN_PROGRESS\",\n" +
            "  \"projectCode\": \"SP000\",\n" +
            "  \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "}";

    public static final String TASK_UPDATE_REQUEST_EXAMPLE = "{\n" +
            "  \"taskSubject\": \"Sample Task Subject\",\n" +
            "  \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "  \"taskStatus\": \"IN_PROGRESS\",\n" +
            "  \"projectCode\": \"SP000\",\n" +
            "  \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "}";

    public static final String TASK_GET_RESPONSE_SINGLE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Task is successfully retrieved.\",\n" +
            "  \"data\": {\n" +
            "    \"taskCode\": \"TS000\",\n" +
            "    \"taskSubject\": \"Sample Task Subject\",\n" +
            "    \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "    \"taskStatus\": \"IN_PROGRESS\",\n" +
            "    \"assignedDate\": \"2024-01-01\",\n" +
            "    \"projectCode\": \"SP000\",\n" +
            "    \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "  }\n" +
            "}";

    public static final String TASK_CREATE_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"CREATED\",\n" +
            "  \"message\": \"Task is successfully created.\",\n" +
            "  \"data\": {\n" +
            "    \"taskCode\": \"TS000\",\n" +
            "    \"taskSubject\": \"Sample Task Subject\",\n" +
            "    \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "    \"taskStatus\": \"IN_PROGRESS\",\n" +
            "    \"assignedDate\": \"2024-01-01\",\n" +
            "    \"projectCode\": \"SP000\",\n" +
            "    \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "  }\n" +
            "}";

    public static final String TASK_UPDATE_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Task is successfully updated.\",\n" +
            "  \"data\": {\n" +
            "    \"taskCode\": \"TS000\",\n" +
            "    \"taskSubject\": \"Sample Task Subject\",\n" +
            "    \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "    \"taskStatus\": \"IN_PROGRESS\",\n" +
            "    \"assignedDate\": \"2024-01-01\",\n" +
            "    \"projectCode\": \"SP000\",\n" +
            "    \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "  }\n" +
            "}";

    public static final String TASK_COMPLETE_BY_PROJECT_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Tasks are successfully completed.\",\n" +
            "}";

    public static final String TASK_DELETE_BY_PROJECT_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Tasks are successfully deleted.\",\n" +
            "}";

    public static final String TASK_GET_RESPONSE_LIST_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Tasks are successfully retrieved.\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"taskCode\": \"TS000\",\n" +
            "      \"taskSubject\": \"Sample Task Subject - 1\",\n" +
            "      \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "      \"taskStatus\": \"IN_PROGRESS\",\n" +
            "      \"assignedDate\": \"2024-01-01\",\n" +
            "      \"projectCode\": \"SP000\",\n" +
            "      \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"taskCode\": \"TS999\",\n" +
            "      \"taskSubject\": \"Sample Task Subject - 2\",\n" +
            "      \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "      \"taskStatus\": \"OPEN\",\n" +
            "      \"assignedDate\": \"2024-01-01\",\n" +
            "      \"projectCode\": \"SP000\",\n" +
            "      \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String TASK_ARCHIVED_GET_RESPONSE_LIST_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Tasks are successfully retrieved.\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"taskCode\": \"TS000\",\n" +
            "      \"taskSubject\": \"Sample Task Subject - 1\",\n" +
            "      \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "      \"taskStatus\": \"COMPLETED\",\n" +
            "      \"assignedDate\": \"2024-01-01\",\n" +
            "      \"projectCode\": \"SP000\",\n" +
            "      \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"taskCode\": \"TS999\",\n" +
            "      \"taskSubject\": \"Sample Task Subject - 2\",\n" +
            "      \"taskDetail\": \"This is a sample task for demonstration purposes.\",\n" +
            "      \"taskStatus\": \"COMPLETED\",\n" +
            "      \"assignedDate\": \"2024-01-01\",\n" +
            "      \"projectCode\": \"SP000\",\n" +
            "      \"assignedEmployee\": \"john.doe@example.com\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String TASK_COUNTS_BY_PROJECT_CODE_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Task counts are successfully retrieved.\",\n" +
            "  \"data\": {\n" +
            "    \"completedTaskCount\": 3,\n" +
            "    \"nonCompletedTaskCount\": 6\n" +
            "  }\n" +
            "}";

    public static final String TASK_NON_COMPLETED_COUNT_BY_ASSIGNED_EMPLOYEE_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": true,\n" +
            "  \"statusCode\": \"OK\",\n" +
            "  \"message\": \"Task count is successfully retrieved.\",\n" +
            "  \"data\": 7\n" +
            "}";

    public static final String MANAGER_NOT_RETRIEVED_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Manager cannot be retrieved.\",\n" +
            "  \"httpStatus\": \"INTERNAL_SERVER_ERROR\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Access is denied\",\n" +
            "  \"httpStatus\": \"FORBIDDEN\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Access denied, make sure that you are working on your own project.\",\n" +
            "  \"httpStatus\": \"FORBIDDEN\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Access denied, make sure that you are working on your own task.\",\n" +
            "  \"httpStatus\": \"FORBIDDEN\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String TASK_ALREADY_EXISTS_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Task already exists.\",\n" +
            "  \"httpStatus\": \"CONFLICT\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String PROJECT_CHECK_FAILED_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Project check is failed.\",\n" +
            "  \"httpStatus\": \"INTERNAL_SERVER_ERROR\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String EMPLOYEE_CHECK_FAILED_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Employee check is failed.\",\n" +
            "  \"httpStatus\": \"INTERNAL_SERVER_ERROR\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String PROJECT_NOT_FOUND_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Project does not exist.\",\n" +
            "  \"httpStatus\": \"NOT_FOUND\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String TASK_NOT_FOUND_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Task does not exist.\",\n" +
            "  \"httpStatus\": \"NOT_FOUND\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String USER_NOT_FOUND_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"User does not exist.\",\n" +
            "  \"httpStatus\": \"NOT_FOUND\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String USER_NOT_EMPLOYEE_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"User is not an employee.\",\n" +
            "  \"httpStatus\": \"CONFLICT\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String EMPLOYEE_NOT_FOUND_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Employee does not exist.\",\n" +
            "  \"httpStatus\": \"CONFLICT\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\"\n" +
            "}";

    public static final String VALIDATION_EXCEPTION_RESPONSE_EXAMPLE = "{\n" +
            "  \"success\": false,\n" +
            "  \"message\": \"Invalid Input(s)\",\n" +
            "  \"httpStatus\": \"BAD_REQUEST\",\n" +
            "  \"localDateTime\": \"2024-01-01T00:00:00.0000000\",\n" +
            "  \"errorCount\": 1,\n" +
            "  \"validationExceptions\": [\n" +
            "    {\n" +
            "      \"errorField\": \"projectName\",\n" +
            "      \"rejectedValue\": \"SP\",\n" +
            "      \"reason\": \"Project name length should be min 3, max 16.\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

}
