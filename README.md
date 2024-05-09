About Nimap Machine Test
NimapMachineTestApp is Project I have uploaded on github as my submission for task.

In this project there is a project architecture like

:-> model classes are  Category Product
:-> Dao CategoryDAo ProductDao 
:-> Service CategoryService and  ProductService 
:->Controller - CategoryController ProductController
:->Implementation classes of CategoryService and  ProductService are CategoryServiceImpl ProductServiceImpl respectively.

Category:->

Insert: To insert a new record there is link : http://localhost:8080/api/categories (It takes whole category object eg. cname, cid as parameter through request body
          {
            "cid": 7,
            "cname": "Electronics"
        }  // need to add this in the JSON FORMAT
        )

Find All: To show all records there is link : http://localhost:8080/api/categories
find All:(Pagination)  to show records through pagination Link: http://localhost:8080/api/categories/?page=1 (just change page = 1, or page =0, or page = 3 etc)
delete: To delete a record there is link : http://localhost:8080/api/categories (It takes category id i.e cid into request param eg. http://localhost:8080/api/categories?a=2 )

update: To update a record there is link : http://localhost:8080/api/categories (It takes cid as request param and whole category object as request body eg. http://localhost:8080/api/categories?a=2 { "cname": "cosmetic", "id": 2 } )

Product:->

To insert a new record there is link : http://localhost:8080/api/products
To get Product By Id: to fetch a record according to a particular id. link : http://localhost:8080/api/products/10 (takes pid as parameter)
Find All: (Pagination) To show all records there is link : http://localhost:8080/api/products/?=page=1 (just change page = 1, or page =0, or page = 3 etc)

delete: To delete a record there is link : http://localhost:8080/api/products ( http://localhost:8080/api/products/1 )

update: To update a record there is link : http://localhost:8080/api/products/2/5 (this takes product pid and the cid as parameter to update a record)
