package com.dlp.java.maxarea;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class MaxArea {

    /**
     * Given an array of building heights. This method finds the maximum area formed by the rectangle of consecutive buildings.
     *
     * @param height
     * @return
     */
    public long findMaxArea(int[] height) {
        class BuildingInfo {
            int height;
            int position;

            BuildingInfo(int height, int position) {
                this.height = height;
                this.position = position;
            }
        }

        Stack<BuildingInfo> myStack = new Stack<>();
        long maxArea = 0;
        for (int index = 0; index < height.length; index++) {
            int currentHeight = height[index];
            if (!(myStack.isEmpty() || myStack.peek().height <= currentHeight)) {
                while (!myStack.isEmpty() && myStack.peek().height > currentHeight) {
                    BuildingInfo bi = myStack.pop();
                    maxArea = Math.max(maxArea, (index - (myStack.isEmpty() ? 0 : myStack.peek().position + 1)) * bi.height);
                }
            }
            myStack.push(new BuildingInfo(height[index], index));
        }

        if (!myStack.isEmpty()) {
            int maxPosition = myStack.peek().position;
            while (!myStack.isEmpty()) {
                BuildingInfo bi = myStack.pop();
                if (myStack.isEmpty()) {
                    maxArea = Math.max(maxArea, (maxPosition + 1) * bi.height);
                } else {
                    maxArea = Math.max(maxArea, (maxPosition - myStack.peek().position) * bi.height);
                }
            }
        }
        return maxArea;
    }
}
