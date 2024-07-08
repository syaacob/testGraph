
# Autonomous Mail Delivery Trains.

backend engineer test




## Authors

- Saiful Yaacob


## Installation

```bash
Create a folder inside input directory
This script required 3 input to run.
1. graph.json
2. train.json
3. package.json

those three files should be create in input directory inside the path.
example:

Users/saiful/workspace/testGraph
    -input
        -sample2
            + graph.json
            + train.json
            + package.json
```

## Run Locally

Clone the project

Go to the project directory then execute
please specify path to input/sample directory


```bash
  ./gradlew run --args=input/sample2
```

## JSON Input Reference
### graph.json
 Parameter       | Type     | Description                                             |
|:----------------|:---------|:--------------------------------------------------------|
| `from`          | `string` | **Required**. start node                                |
| `to`            | `[]`     | **Required**. array of edges                            |
| `to[].duration` | `string` | **Required**. time take to travel between edges(weight) |
| `to[].node`     | `string` | **Required**. edges                                     |
| `to[].name`     | `string` | **Required**. name of edges                             |

### train.json
 Parameter  | Type      | Description                                 |
|:-----------|:----------|:--------------------------------------------|
| `name`     | `string`  | **Required**. train name                    |
| `capacity` | `integer` | **Required**. maximum capacity of the train |
| `starting` | `string`  | **Required**. starting node of the train    |

### package.json
 Parameter     | Type      | Description                                   |
|:--------------|:----------|:----------------------------------------------|
| `name`        | `string`  | **Required**. name of package                 |
| `weight`      | `integer` | **Required**. weight of the package           |
| `starting`    | `string` | **Required**. starting node of the package    |
| `destination` | `string` | **Required**. destination node of the package |

## JSON Input Example
### graph.json
```json
[
  {
    "from": "A",
    "to": [
      {
        "duration" : 30,
        "node": "B",
        "name" : "E1"
      }
    ]
  },
  {
    "from": "B",
    "to": [
      {
        "duration" : 10,
        "node": "C",
        "name" : "E2"
      }
    ]
  }
]
```
This will create graph like this

```bash
A--(30)--B--(10)--C
```

### train.json
```json
[
  {
    "name" : "train_1",
    "capacity" : 30,
    "starting" : "A"
  },
  {
    "name" : "train_2",
    "capacity" : 50,
    "starting" : "B"
  }
]
```
### package.json
```json
[
  {"name":  "p1", "weight" : 10, "starting":  "A", "destination" :  "C"}
]
```