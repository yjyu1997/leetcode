package ms.hard.trapping_rain_water;

/**
 * Solution2
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.01,2021</pre>
 */
public class Solution2 {

    public int trap(int[] height) {

        int length = height.length;
        int leftMax = 0;
        int rightMax = 0;

        int _left = 0;
        int _right = length - 1;

        if(length == 0){
            return 0;
        }


        int ans = 0;

        while(_left != _right){

            //if h(_left) < h(_right), then we have leftMax < rightMax
            //prove:
            //case1: if we previously move the _left to right index.
            //then rightMax = h(_right)
            // h(_left - 1) < h(right)
            // h(_left) < h(right) ---->
            // leftMax = max[h(_left),h(_left - 1)] < h(right)

            //case2: if we previously move the _right to left index.
            //then leftMax = h(_left)
            // h(_right + 1) < h(_left)
            // h(_right) > h(_left)
            //rightMax = max[h(_right),h(_right + 1)] > h(_left)
            if(height[_left] < height[_right]){
                //update the leftMax
                leftMax = Math.max(leftMax, height[_left]);
                //calculate the volume
                ans += leftMax - height[_left];
                //mv _left to right
                _left = _left + 1;
            }

            //else if h(_right) <= h(_left), then we have rightMax <= leftMax
            //prove:
            //case1: if we previously move the _left to right index.
            //then rightMax = h(_right)
            //  h(_right) <= h(_left)
            // h(_right) > h(_left - 1)
            // leftMax = max[h(_left), h(_left-1)] >= h(_right) = rightMax

            //case2: if we previously move the _right to left index.
            //then leftMax = h(_left)
            // h(_right + 1) <= h(_left)
            // h(_right) <= h(_left)
            // rightMax =  max[h(_right),h(_right + 1)] <= leftMax
            else{
                //update the rightMax
                rightMax = Math.max(rightMax, height[_right]);
                //calculate the volume
                ans += rightMax - height[_right];
                //mv _right to left
                _right = _right - 1;
            }
        }


        return ans;
    }




}
