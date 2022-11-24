import React, { useState } from "react";
import { Data } from "../MOCK_DATA";
import { DataGrid, GridColDef } from "@mui/x-data-grid";


const ReduxComponent = () => {
    const [value, setValue] = useState(0);
    
    const handleClick = (e, cellValue) => {

        console.log(cellValue.row.id)
        products.find( product => 
            { 
                if (product.id == cellValue.row.id){
                    if (cellValue.row.stock > value) {
                        product.stock = cellValue.row.stock - value;
                    }
            }
            } );
      };
      const handleChange = (e) => {
        setValue(e.target.value)
      };
    const columns: GridColDef[] = [
      { field: "id", headerName: "ID", width: 70 },
      { field: "product_name", headerName: "Product Name", width: 200 },
      { field: "stock", headerName: "Stock", width: 130 },
      {
        field: "product_image",
        headerName: "Image",
        width: 130,
        renderCell: (params) => <img src={params.value} />,
      },
      {
        field: "Action",
        type: 'number',
         width: 230,
        renderCell: (cellValues) => {
            return (
                <>
                <input style={{width: "80%"}} onChange={(e) => handleChange(e)}></input>
              <button
                variant="contained"
                color="primary"
                onClick={(event) => {
                    handleClick(event, cellValues);
                }}
                >
                Submit
              </button>
                  </>
            );
          }
      },
    ];
  var products = Data();
  return (
    <div style={{ height: 600 , width: "100%" }}>
      <DataGrid
        rows={products}
        columns={columns}
        pageSize={10}
        rowsPerPageOptions={[10]}
      />
    </div>
    //    products.map(product => (
    //        <div>
    //            <text>{product.product_name}</text>
    //            <text>{product.stock}</text>
    //            <img src={product.product_image}></img>
    //        </div>

    //    )
    //  )
  );
};

export default ReduxComponent;
