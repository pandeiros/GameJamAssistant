# GamJamApp

# Group Auth

## Register [/register/]

### Register new user [POST]

+ Request (application/json)
    + Attributes
        + username: user_1
        + password: asdasdqwe123123123
        + repeat_password: asdasdqwe123123123
        + email: agat@gmail.com
        + code: JHSVS7647HG66

+ Response 200 (application/json)
    + Attributes
        + token: abcdefghijklmnoprstuwxyz
        + user (User1)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)



## Session [/auth/session]
To logout delete JWT Token received during login.

### Log in to system [POST]

+ Request (application/json)
    + Attributes
        + username: user_1
        + password: asdasdqwe123123123

+ Response 200 (application/json)
    + Attributes
        + token: abcdefghijklmnoprstuwxyz
        + user (User1)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)



# Group User

## User info management [/account/]
### Get user info [GET]

+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)
    + Attributes (User1)

+ Response 404 (application/json)

### Update user info [PATCH]

+ Request (application/json)
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz
    + Attributes (UserRequest)

+ Response 201 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)

### Update profile picture [POST]
+ Request (application/json)
    + Attributes
        + file
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)


# Group Team

## Team info [/team/users/]
### Get team info [GET]

+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)
    + Attributes (array[User2, User3])

+ Response 404 (application/json)

## Specific user [/team/users/{id}]
+ Parameters
    + id: 98473748 (string) - user id

### Get user [GET]
+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)
    + Attributes (User3)

+ Response 404 (application/json)

### Accept user [POST]
Accept pending user request

+ Request (application/json)
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)

### Reject user [DELETE]
Reject pending user request

+ Request (application/json)
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)

# Group Games

## Games list [/games/]
## Get list of games [GET]

+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)

        [
            {
                "id" : 1,
                "title" : "Flowdesk",
                "description" : "Fusce consequat. Nulla nisl. Nunc nisl.\n\nDuis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.",
                "rating" : 2.4,
                "votes" : 5,
                "screenshots" : [
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://media.moddb.com/images/games/1/12/11583/eadd34a.jpg"
                ],
                "team_id" : 1
            },
            {
                "id":2,
                "title":"Tempsoft",
                "desc":"Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.\n\nProin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.",
                "rating": 4.1,
                "votes": 30,
                "screenshots": [
                    "http://cache.gawkerassets.com/assets/images/9/2011/10/acr_sp_sc_29_sd_forumofox.jpg",
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg"
                ],
                "team_id" : 2
            },
            {
                "id":3,
                "title":"Kanlam",
                "desc":"Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.",
                "rating": 3.5,
                "votes": 10,
                "screenshots": [
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg",
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://cache.gawkerassets.com/assets/images/9/2011/10/acr_sp_sc_29_sd_forumofox.jpg",
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg",
                    "http://cache.gawkerassets.com/assets/images/9/2011/10/acr_sp_sc_29_sd_forumofox.jpg"
                ],
                "team_id" : 3

            },
            {
                "id":4,
                "title":"Keylex",
                "desc":"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.",
                "rating": 3.0,
                "votes": 10,
                "screenshots": [
                    "http://cache.gawkerassets.com/assets/images/9/2011/10/acr_sp_sc_29_sd_forumofox.jpg",
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg",
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg"
                ],
                "team_id" : 4
            },
            {
                "id":5,
                "title":"Cardify",
                "desc":"In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.",
                "rating": 1.7,
                "votes": 70,
                "screenshots": [
                    "http://i.imgur.com/Cc1yV.jpg",
                    "http://i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg",
                    "http://cache.gawkerassets.com/assets/images/9/2011/10/acr_sp_sc_29_sd_forumofox.jpg"
                ],
                "team_id" : 5
            }
        ]


+ Response 404 (application/json)


## Specific game [/games/{id}]
+ Parameters
    + id: 1 (string) - game id

### Get game [GET]

+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)
    
        {
            "id" : 1,
            "title" : "Flowdesk",
            "description" : "Fusce consequat. Nulla nisl. Nunc nisl.\n\nDuis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.",
            "rating" : 2.4,
            "votes" : 5,
            "screenshots" : [
                "http://i.imgur.com/Cc1yV.jpg",
                "http://media.moddb.com/images/games/1/12/11583/eadd34a.jpg"
            ],
            "team_id" : 1
        }

+ Response 404 (application/json)

### Update game info [PATCH]

+ Request (application/json)
    + Attributes (GameRequest)
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 201 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)

### Add screenshot [POST]

+ Request (application/json)
    + Attributes
        + file
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 201 (application/json)

+ Response 400 (application/json)
    + Attributes (ErrorResponse)


# Group Events

## Listing events [/events/]

### Get list of events [GET]

+ Request
    + Headers

            Authorization: Bearer abcdefghijklmnoprstuwxyz

+ Response 200 (application/json)
    + Attributes (array[Event1, Event2])

+ Response 404 (application/json)

# Data Structures


## User1
+ user_id: 343245453
+ name: `Paweł Kaczyński`
+ username: `panda`
+ email: `pkaczyn@gmail.com`
+ location: `Warsaw, Poland`
+ team_id: 1
+ picture_url: `https://robohash.org/panda.png`
+ status: `accepted`

## User2
+ user_id: 343265453
+ name: `Agata Dębska`
+ username: `agat`
+ email: `adebska@gmail.com`
+ location: `Warsaw, Poland`
+ team_id: 1
+ picture_url: `https://robohash.org/agat.png`
+ status: `accepted`

## User3
+ user_id: 98473748
+ name: `Adrianna Kmieciak`
+ username: `dziku`
+ email: `dydo@gmail.com`
+ location: `Warsaw, Poland`
+ team_id: 1
+ picture_url: `https://robohash.org/dziku.png`
+ status: `accepted`

## User4
+ user_id: 92343748
+ name: `Marek Bierdzycki`
+ username: `markovich`
+ email: `markovich@gmail.com`
+ location: `Warsaw, Poland`
+ team_id: 1
+ picture_url: `https://robohash.org/markovich.png`
+ status: `pending`

## UserRequest
+ name: `Paweł Kaczyński`
+ username: `panda`
+ email: `pkaczyn@gmail.com`
+ location: `Warsaw, Poland`

## Team
+ name: `Skivee`
+ users: (array[User1, User2, User3, User4])
+ game: (Game1)

## Screenshot1
+ picture_url: `i.imgur.com/Cc1yV.jpg`

## Screenshot3
+ picture_url: `i.kinja-img.com/gawker-media/image/upload/vdlqqt4tb2ycrwr3ucru.jpg`

## Game1
+ game_id: 16437654
+ title: `Kanlam`
+ description: `Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.`
+ rating: 4.0
+ votes: 10
+ screenshots: (array[Screenshot1, Screenshot3])
+ team_id : 1

## Game2
+ game_id: 164876654
+ title: `Keylex`
+ description: `Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.`
+ rating: 3.5
+ votes: 5
+ screenshots: (array[Screenshot3, Screenshot1])
+ team_id : 3



## GameRequest
+ title: `Kanlam`
+ description: `Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.`

## Event1
+ title: `Warsztaty Unity`
+ start: `2016-01-01T00:12:00+01:00`
+ end: `2016-01-01T00:14:00+01:00`

## Event2
+ title: `Obiad`
+ start: `2016-01-01T00:14:00+01:00`
+ end: `2016-01-01T00:15:00+01:00`

## AuthSession
+ user_id: asdasdasd
+ user_type: owner

## ErrorResponse (object)
+ error_code: `NAME_TOO_LONG` (string) - Translatable error code
+ message: `Provided name is too long. It cannot be longer than 50 characters.` (string) - API's message to the client