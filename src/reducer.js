const SET_VAL = 'SET_VAL';

export const setVal = (val) => ({
    type: SET_VAL,
    val
});

const myFirstReducer = (state = {val:0}, action) => {
    switch (action.type) {
        case SET_VAL: {
            return {
                ...state,
                val: action.val
            };
        }
        default:
            return state;
    }
};

export default myFirstReducer