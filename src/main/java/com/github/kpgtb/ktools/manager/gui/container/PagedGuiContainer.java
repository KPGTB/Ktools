/*
 *    Copyright 2023 KPG-TB
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.kpgtb.ktools.manager.gui.container;

import com.github.kpgtb.ktools.manager.debug.DebugManager;
import com.github.kpgtb.ktools.manager.debug.DebugType;
import com.github.kpgtb.ktools.manager.gui.KGui;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Paged gui container contains specific box of items from GUI with pages system
 */
public class PagedGuiContainer extends GuiContainer {
    private final DebugManager debug;

    private final ArrayList<GuiContainer> containers;
    private int page;

    /**
     * Constructor for container that is part of GUI
     * @param debug Instance of DebugManager
     * @param gui Instance of KGui
     * @param x X position in KGui (0-8)
     * @param y Y position in KGui (0-[KGui rows - 1])
     * @param width Width of container (1-9)
     * @param height Height of container (1-[KGui rows])
     */
    public PagedGuiContainer(DebugManager debug, @NotNull KGui gui, int x, int y, int width, int height) {
        super(debug, gui, x, y, width, height);
        this.debug = debug;
        this.containers = new ArrayList<>();
        this.page = 0;
    }

    public ArrayList<GuiContainer> getContainers() {
        return containers;
    }

    /**
     * Add page to container
     * @param container Container that is part of PagedGuiContainer
     */
    public void addPage(GuiContainer container) {
        if(container.getPagedGuiContainer() != this) {
            this.debug.sendWarning(DebugType.GUI, "Container is not a part of this paged container");
            return;
        }
        this.containers.add(container);
        // If this is a first container then update it
        if(this.containers.size() == 1) {
            update();
        }
    }

    /**
     * Remove page from container
     * @param container Container that is part of PagedGuiContainer
     */
    public void removePage(GuiContainer container) {
        this.containers.remove(container);
    }

    /**
     * Update items in paged container
     */
    public void update() {
        super.setItems(this.containers.get(page).getItems());
        super.getGui().update();
    }

    /**
     * Get page index
     * @return current page index
     */
    public int getPageIdx() {
        return page;
    }

    /**
     * Set page index and auto update container
     * @param page new page index
     */
    public void setPageIdx(int page) {
        this.page = page;
        this.update();
    }

    /**
     * Change page to previous
     */
    public void previousPage() {
        if(page > 0) {
            setPageIdx(page - 1);
        }
    }

    /**
     * Change page to next
     */
    public void nextPage() {
        if((this.containers.size() - 1) > page) {
            setPageIdx(page + 1);
        }
    }
}
