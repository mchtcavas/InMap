# InMap
A service that allows you to search for nearby places

# `application.yml` Configuration File

This file contains various configuration settings for your application. Below are the explanations for each configuration section.

## `application`

Contains the basic configuration settings for the application.

### `nearby-template`

This section specifies the API key to be used by the application. The `key` value can be set to either `google` or `mock`:

- **key: google**  
  Uses the Google API key (this option is commented out and is not currently used).

- **key: mock**  
  Uses the Mock API key.

### `google`

Contains configuration settings required for Google API.

#### `api`

- **base-url**  
  The base URL for the Google Places API. This is the URL that the application will use to make requests to the Google Places API.  
  `https://maps.googleapis.com/maps/api/place/nearbysearch/json`

- **key**  
  Your Google API key. This key is necessary for accessing the Google API.  
  `YOUR_API_KEY` (Replace this with your actual API key.)

### `mock`

Contains configuration settings required for the Mock API.

#### `api`

- **base-url**  
  The base URL for the Mock API. This is the URL that the application will use to make requests to the mock API.  
  `https://mocki.io/v1/120a45f3-0643-4ae7-b035-436d6c5dca7c`

## `springdoc`

This section contains configuration settings for Springdoc OpenAPI, which is used for generating API documentation.

### `api-docs`

- **path**  
  The path at which the OpenAPI documentation will be available.  
  `/v3/api-docs`

### `swagger-ui`

- **path**  
  The path at which the Swagger UI will be available. This UI provides a graphical interface to interact with the API documentation.  
  `/swagger-ui.html`
